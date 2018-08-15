#posobly on the trained model it has a few characters at the beggining so it doesn't work???

import os
import numpy as np
import tensorflow as tf
from tensorflow import keras

file_path = "training_1/cp.cpkt"
word_size = 18

print("Program that uses a neural net to distinguish between Spanish and English words")
print("Amroximately 94% acurite currently")
print("If word equals '/exit' then the program will exit")
print(" ")

word = ""

def changeToBit():
    bin = []
    test = np.array((np.zeros((word_size,8))))
    word_length = len(word)
    if word_length>word_size:
        word_length=word_size
    for x in range(word_length):
         bin = format(ord(word[x]),'b')  # convert to binary starts at 97
         for y in range(len(bin)):
             test[x][y] =  bin[y]
    return test

while (word != "/exit"):
    word = raw_input("word? ")
    #print(word)
    words = np.array(np.zeros((1,word_size,8)))
    words[0] = changeToBit() # converts word to binary

    model = keras.models.load_model('model.h5')
    predictions = model.predict(words)
    if  predictions[0]>0.5:
        print "Spanish    confidence =" , round(float(predictions[0])*100,3) , "%"
    else:
        print "English    confidence =" , round(100 - float(predictions[0])*100,3) , "%"
    #print(words)
