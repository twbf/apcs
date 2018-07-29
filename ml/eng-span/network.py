import tensorflow as tf
from tensorflow import keras
import math
import numpy as np
import random

english = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/english3.txt", "r")
spanish = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/spanish.txt", "r")
eng = english.readlines()
spn = spanish.readlines()

t_size = 150000

def changeToBit(index, lang):

    bin = []
    test = np.array((np.zeros((20,8))))
    if lang == 1:  #english
        word_length = len(eng[index])
        if word_length>20:
            word_length=20
        for x in range(word_length):
             bin = format(ord(eng[index][x]),'b')  # convert to binary starts at 97
             for y in range(len(bin)):
                 test[x][y] =  bin[y]
        return test
    else:          #spanish
        word_length = len(spn[index])
        if word_length>20:
            word_length=20
        for x in range(word_length):
             bin = format(ord(spn[index][x]),'b')  # convert to binary starts at 97
             for y in range(len(bin)):
                 test[x][y] =  bin[y]
        return test

e = np.array(np.zeros((t_size,20,8)))
s = np.array(np.zeros((t_size,20,8)))

for i in range(t_size):
    b = changeToBit(i,1)
    e[i] = b

    b = changeToBit(i,0)
    s[i] = b


train_in = np.array(np.zeros((t_size,20,8)))
train_out = np.array(np.zeros((t_size)))
val_in = np.array(np.zeros((t_size,20,8)))
val_out = np.array(np.zeros((t_size)))

for x in range(0,t_size):
    r = random.random()
    if r<0.5:
        train_in[x] = e[x]
        train_out[x] = 0
        val_in[x] = s[x]
        val_out[x] = 1
    else:
        train_in[x] = s[x]
        train_out[x] = 1
        val_in[x] = e[x]
        val_out[x] = 0



def network():
    model = keras.Sequential()
    model.add(keras.layers.Flatten(input_shape = (20,8)))
    #model.add(keras.layers.Dropout(0.4))
    model.add(keras.layers.Dense(100, activation = tf.nn.relu))
    #model.add(keras.layers.Dropout(0.4))
    model.add(keras.layers.Dense(50, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='binary_crossentropy',
              metrics=['accuracy'])
    history = model.fit(train_in,
                    train_out,
                    epochs=100,
                    batch_size=100,
                    validation_data=(val_in, val_out),
                    verbose=1)
    predictions = model.predict(val_in)
    for x in range(100):
        language = val_out[x]
        predict = predictions[x]
        if language == 0:
            word = eng[x]
        else:
            word = spn[x]
        print str(word) + ' - ' + str(language) + ' - ' + str(predict)
network()
