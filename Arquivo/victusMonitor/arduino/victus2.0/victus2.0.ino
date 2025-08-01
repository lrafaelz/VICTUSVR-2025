#include <string.h>

int rr = 0;
char texto[60];
char texto1[60];
char texto2[60];
char tex[24];
char tex2[24];
char tex3[24];
int analogInput[5] = {A1, A2, A3, A4, A5};  
// variable to store the value 
int value[5] = {0, 0, 0, 0, 0};  

// variaveis do sensor hall ///////////////////
int seg_acumulado = 0;
int seg=0;
int min=0;
// define a porta para o acionamento do led
int pinosinal = 4;    
// Armazena informações sobre a leitura do sensor
int leitura;          
long startTime ;                    // momento de partida do cronômetro
long elapsedTime ;                  // tempo decorrido no cronômetro
int fractional;                     // variável a guardar parte fracionária do tempo
int numero = 1;
int i=0;
int j=0;

//char texto[24];
/////////////////////////////////////////////////////
// coleta do sensor
float distancia = 0.0000;
float distancia_ideal = 0.0000;
float velocidade = 0.0000;
float velocidade_real = 0.0000;
float emg = 4.20;
int EMG;
// dados por segundo
int   BPM_segundo[30];
float DIS_segundo[30];
float VEL_segundo[30];
float EMG_segundo[30];
// dados parciais
int   parcial_BPM = 0;
float parcial_DIS = 0.00;
float parcial_VEL = 0.00;
float parcial_EMG = 0.00;
// media final
int   media_BPM = 0;
float media_DIS = 0.00;
float media_VEL = 0.00;
float media_EMG = 0.00;
// soma intermediaria
int   s_BPM = 0;
float s_VEL = 0.00;
float s_EMG = 0.00;
// equacoes
float x1 = 0.00;
float x2 = 0.00;
float x3 = 0.00;
//////////////////////////////////////////////////

// variaveis do sensor de batimentos /////////////
int pulsePin = 0;                 // Pulse Sensor purple wire connected to analog pin 0
int blinkPin = 13;                // pin to blink led at each beat
int fadePin = 5;                  // pin to do fancy classy fading blink at each beat
int fadeRate = 0;                 // used to fade LED on with PWM on fadePin
// Volatile Variables, used in the interrupt service routine!
volatile int BPM;                   // int that holds raw Analog in 0. updated every 2mS
volatile int Signal;                // holds the incoming raw data
volatile int IBI = 600;             // int that holds the time interval between beats! Must be seeded! 
volatile boolean Pulse = false;     // "True" when User's live heartbeat is detected. "False" when not a "live beat". 
volatile boolean QS = false;        // becomes true when Arduoino finds a beat.
// Regards Serial OutPut  -- Set This Up to your needs
static boolean serialVisual = false;   // Set to 'false' by Default.  Re-set to 'true' to see Arduino Serial Monitor ASCII Visual Pulse
volatile int rate[10];                    // array to hold last ten IBI values
volatile unsigned long sampleCounter = 0;          // used to determine pulse timing
volatile unsigned long lastBeatTime = 0;           // used to find IBI
volatile int P =512;                      // used to find peak in pulse wave, seeded
volatile int T = 512;                     // used to find trough in pulse wave, seeded
volatile int thresh = 525;                // used to find instant moment of heart beat, seeded
volatile int amp = 100;                   // used to hold amplitude of pulse waveform, seeded
volatile boolean firstBeat = true;        // used to seed rate array so we startup with reasonable BPM
volatile boolean secondBeat = false;      // used to seed rate array so we startup with reasonable BPM
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

// funcoes do sensor de batimentos ////////////////////////////
void interruptSetup(){     
  // Initializes Timer2 to throw an interrupt every 2mS.
  TCCR2A = 0x02;     // DISABLE PWM ON DIGITAL PINS 3 AND 11, AND GO INTO CTC MODE
  TCCR2B = 0x06;     // DON'T FORCE COMPARE, 256 PRESCALER 
  OCR2A = 0X7C;      // SET THE TOP OF THE COUNT TO 124 FOR 500Hz SAMPLE RATE
  TIMSK2 = 0x02;     // ENABLE INTERRUPT ON MATCH BETWEEN TIMER2 AND OCR2A
  sei();             // MAKE SURE GLOBAL INTERRUPTS ARE ENABLED      
} 


// THIS IS THE TIMER 2 INTERRUPT SERVICE ROUTINE. 
// Timer 2 makes sure that we take a reading every 2 miliseconds
ISR(TIMER2_COMPA_vect){                         // triggered when Timer2 counts to 124
  cli();                                      // disable interrupts while we do this
  Signal = analogRead(pulsePin);              // read the Pulse Sensor 
  sampleCounter += 2;                         // keep track of the time in mS with this variable
  int N = sampleCounter - lastBeatTime;       // monitor the time since the last beat to avoid noise

    //  find the peak and trough of the pulse wave
  if(Signal < thresh && N > (IBI/5)*3){       // avoid dichrotic noise by waiting 3/5 of last IBI
    if (Signal < T){                        // T is the trough
      T = Signal;                         // keep track of lowest point in pulse wave 
    }
  }

  if(Signal > thresh && Signal > P){          // thresh condition helps avoid noise
    P = Signal;                             // P is the peak
  }                                        // keep track of highest point in pulse wave

  //  NOW IT'S TIME TO LOOK FOR THE HEART BEAT
  // signal surges up in value every time there is a pulse
  if (N > 250){                                   // avoid high frequency noise
    if ( (Signal > thresh) && (Pulse == false) && (N > (IBI/5)*3) ){        
      Pulse = true;                               // set the Pulse flag when we think there is a pulse
      digitalWrite(blinkPin,HIGH);                // turn on pin 13 LED
      IBI = sampleCounter - lastBeatTime;         // measure time between beats in mS
      lastBeatTime = sampleCounter;               // keep track of time for next pulse

      if(secondBeat){                        // if this is the second beat, if secondBeat == TRUE
        secondBeat = false;                  // clear secondBeat flag
        for(int i=0; i<=9; i++){             // seed the running total to get a realisitic BPM at startup
          rate[i] = IBI;                      
        }
      }

      if(firstBeat){                         // if it's the first time we found a beat, if firstBeat == TRUE
        firstBeat = false;                   // clear firstBeat flag
        secondBeat = true;                   // set the second beat flag
        sei();                               // enable interrupts again
        return;                              // IBI value is unreliable so discard it
      }   


      // keep a running total of the last 10 IBI values
      word runningTotal = 0;                  // clear the runningTotal variable    

      for(int i=0; i<=8; i++){                // shift data in the rate array
        rate[i] = rate[i+1];                  // and drop the oldest IBI value 
        runningTotal += rate[i];              // add up the 9 oldest IBI values
      }

      rate[9] = IBI;                          // add the latest IBI to the rate array
      runningTotal += rate[9];                // add the latest IBI to runningTotal
      runningTotal /= 10;                     // average the last 10 IBI values 
      BPM = 60000/runningTotal;               // how many beats can fit into a minute? that's BPM!
      QS = true;                              // set Quantified Self flag 
      // QS FLAG IS NOT CLEARED INSIDE THIS ISR
    }                       
  }

  if (Signal < thresh && Pulse == true){   // when the values are going down, the beat is over
    digitalWrite(blinkPin,LOW);            // turn off pin 13 LED
    Pulse = false;                         // reset the Pulse flag so we can do it again
    amp = P - T;                           // get amplitude of the pulse wave
    thresh = amp/2 + T;                    // set thresh at 50% of the amplitude
    P = thresh;                            // reset these for next time
    T = thresh;
  }

  if (N > 2500){                           // if 2.5 seconds go by without a beat
    thresh = 512;                          // set thresh default
    P = 512;                               // set P default
    T = 512;                               // set T default
    lastBeatTime = sampleCounter;          // bring the lastBeatTime up to date        
    firstBeat = true;                      // set these to avoid noise
    secondBeat = false;                    // when we get the heartbeat back
  }

  sei();                                   // enable interrupts when youre done!
}// end isr

void sendDataToSerial(char symbol, int data ){
 //Serial.print(symbol);

  //Serial.println(data);                
  }


//  Code to Make the Serial Monitor Visualizer Work
void arduinoSerialMonitorVisual(char symbol, int data ){    
  const int sensorMin = 0;      // sensor minimum, discovered through experiment
const int sensorMax = 1024;    // sensor maximum, discovered through experiment

  int sensorReading = data;
  // map the sensor range to a range of 12 options:
  int range = map(sensorReading, sensorMin, sensorMax, 0, 11);

  // do something different depending on the 
  // range value:
  switch (range) {
  case 0:     
    Serial.println("");     /////ASCII Art Madness
    break;
  case 1:   
    Serial.println("---");
    break;
  case 2:    
    Serial.println("------");
    break;
  case 3:    
    Serial.println("---------");
    break;
  case 4:   
    Serial.println("------------");
    break;
  case 5:   
    Serial.println("--------------|-");
    break;
  case 6:   
    Serial.println("--------------|---");
    break;
  case 7:   
    Serial.println("--------------|-------");
    break;
  case 8:  
    Serial.println("--------------|----------");
    break;
  case 9:    
    Serial.println("--------------|----------------");
    break;
  case 10:   
    Serial.println("--------------|-------------------");
    break;
  case 11:   
    Serial.println("--------------|-----------------------");
    break;
  
  } 
}

void serialOutput(){   // Decide How To Output Serial. 
 if (serialVisual == true){  
     arduinoSerialMonitorVisual('-', Signal);   // goes to function that makes Serial Monitor Visualizer
 } else{
      sendDataToSerial('S', Signal);     // goes to sendDataToSerial function
 }        
}


//  Decides How To OutPut BPM and IBI Data
void serialOutputWhenBeatHappens(){    
 if (serialVisual == true){            //  Code to Make the Serial Monitor Visualizer Work
    Serial.print("*** Batimenco Cardiaco *** ");  //ASCII Art Madness
    Serial.print("BPM: ");
    Serial.print(BPM);
    Serial.print("  ");
 } else{
        sendDataToSerial('B',BPM);   // send heart rate with a 'B' prefix
        sendDataToSerial('Q',IBI);   // send time between beats with a 'Q' prefix
 }   
}


void ledFadeToBeat(){
    fadeRate -= 15;                         //  set LED fade value
    fadeRate = constrain(fadeRate,0,255);   //  keep LED fade value from going into negative numbers!
    analogWrite(fadePin,fadeRate);          //  fade LED
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////


void setup() {

  pinMode(blinkPin,OUTPUT);         // pin that will blink to your heartbeat!
  pinMode(fadePin,OUTPUT);          // pin that will fade to your heartbeat!
  interruptSetup();  
  for(int i=0;i<5;i++)
  pinMode(analogInput[i], INPUT); 
  Serial.begin(9600);
 
 //randomSeed(analogRead(1));
  //Define o pino do sensor hall como entrada
  pinMode(pinosinal, INPUT);   

}

void loop() {
 int a;
 int sensorValue;

  if (QS == true){     // A Heartbeat Was Found
                       // BPM and IBI have been Determined
                       // Quantified Self "QS" true when arduino finds a heartbeat
        fadeRate = 255;         // Makes the LED Fade Effect Happen
                                // Set 'fadeRate' Variable to 255 to fade LED with pulse
        serialOutputWhenBeatHappens();   // A Beat Happened, Output that to serial.     
        QS = false;                      // reset the Quantified Self flag for next time    
  }
     
  ledFadeToBeat();                      // Makes the LED Fade Effect Happen 
 // delay(20);    

static unsigned long ult_tempo = 0;
  int tempo = millis();
  if(tempo - ult_tempo >= 1000){
  ult_tempo = tempo;
  seg++;
  }

//rr++;

leitura = digitalRead(pinosinal);

 // startTime = millis();
 
  if (leitura != 1)
  {
    
   //startTime = millis();        
    
    while(digitalRead(pinosinal) != 1)
   {
      //startTime = millis();
     // Serial.println("numero de pedaladas:");
     // Serial.println(numero);
      //numero++;
      //if(seg_acumulado == 0 || seg_acumulado != seg){
      //seg_acumulado = seg_acumulado + seg;}
        //Serial.println("seg ac: ");
       //Serial.println(seg_acumulado);
      //emg = 4.0 + ((seg + 1)/61);
      distancia = distancia + 0.1205;
      if(min == 0){
      velocidade_real = (3.6 * (distancia/seg));}
      if(min == 1){
      velocidade_real = (3.6 * (distancia/(seg+60)));}
      if(min == 2){
      velocidade_real = (3.6 * (distancia/(seg+120)));}
      if(min == 3){
      velocidade_real = (3.6 * (distancia/(seg+180)));}
      if(min == 4){
      velocidade_real = (3.6 * (distancia/(seg+240)));}
      //Serial.println("vel: ");
       //Serial.println(velocidade_real);
      velocidade = (10.15 * velocidade_real);
      //sprintf(texto, "%.3f", velocidade);
      for(int i=0;i<5;i++)
  {
    value[i] = analogRead(analogInput[i]);
  }
  EMG = value[0];
      //Serial.println(texto);
      //emg = 4.0 + ((seg + 1)/61);
   if((min != 30) && (rr != seg)){

   
  
   distancia_ideal = ((velocidade_real/3.6)*seg);
   //sensorValue = analogRead(A1);
  // Convert the analog reading (which goes from 0 - 1023) to a voltage (0 - 5V):
   //emg = sensorValue * (5.0 / 1023.0);


  sprintf(texto, "%d", BPM);
  sprintf(texto1, "%d", min);
  sprintf(texto2, "%d", seg);

  char *valor = dtostrf(distancia,4,2,tex);
  char *valor2 = dtostrf(velocidade,5,2,tex2);
  sprintf(tex3, "%d", EMG);
  //char *valor3 = dtostrf(emg,4,2,tex3);
   strcat(texto,"#");
   strcat(texto,valor);
   strcat(texto,"#");
   strcat(texto,valor2);
   strcat(texto,"#");
   strcat(texto,tex3);
   strcat(texto,"#");
   strcat(texto,texto1);
   strcat(texto,"#");
   strcat(texto,texto2);
   //strcat(texto,"#");
   //Serial.println(BPM);
   //delay(1000);
   // Serial.println(rr);
     //Serial.println(seg);
   Serial.println(texto);
   //distancia_ideal++;
 //  delay(1000);
 rr = seg;

   if(min == 30){
    
   }
      
      delay(20);
      //numero++;
    }
    
  }


      if(min !=30 && (seg !=30 || seg != 60)){
   for(i=0; i<30 ; i++){
    if(min != 30 && (seg == i || seg == (i+30))){
      BPM_segundo[i] = BPM;
      VEL_segundo[i] = velocidade;
      //Serial.print("velo");
      //Serial.println(VEL_segundo[i]);
      EMG_segundo[i] = emg;    
     }
    }
  }
   if(min != 30 && seg == 30){
       s_BPM = 0;
       s_VEL = 0;
       s_EMG = 0; 
   for(j=0; j<30; j++){
        s_BPM = s_BPM + BPM_segundo[j];
        s_VEL = s_VEL + VEL_segundo[j];
        s_EMG = s_EMG + EMG_segundo[j];}
      //Serial.print("soma velo");
      //Serial.println(s_VEL);
      parcial_DIS = distancia;
      parcial_BPM = s_BPM/30;
      parcial_VEL = s_VEL/30.00;
      parcial_EMG = s_EMG/30.00;
      BPM_segundo[0] = BPM;
      VEL_segundo[0] = velocidade;
      EMG_segundo[0] = emg;   
       //Serial.println(parcial_BPM);
       //Serial.println(parcial_DIS);
       //Serial.println(parcial_VEL);
       //Serial.println(parcial_EMG);
   }
   if(min != 30 && seg == 60){
       s_BPM = 0;
       s_VEL = 0;
       s_EMG = 0;
    for(j=0; j<30; j++){
        s_BPM = s_BPM + BPM_segundo[j];
        s_VEL = s_VEL + VEL_segundo[j];
        s_EMG = s_EMG + EMG_segundo[j];}
      parcial_DIS = distancia;
      parcial_BPM = s_BPM/30;
      parcial_VEL = s_VEL/30.00;
      parcial_EMG = s_EMG/30.00;
       //Serial.println(parcial_BPM);
       //Serial.println(parcial_DIS);
       //Serial.println(parcial_VEL);
       //Serial.println(parcial_EMG);
     seg = 0;
     min++;
   }
 
  }
  
}
 
