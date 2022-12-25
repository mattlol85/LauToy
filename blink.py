import RPi.GPIO as GPIO
from time import sleep
print("Single Blink LED Script")
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(40, GPIO.OUT, initial=GPIO.LOW)

GPIO.output(40, GPIO.LOW)
sleep(1)
GPIO.output(40, GPIO.HIGH)
sleep(1)
GPIO.output(40, GPIO.LOW)

quit()


    