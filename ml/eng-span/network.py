import tensorflow as tf
from tensorflow import keras
import math
import numpy as np
from random import *

english = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/english.txt", "r")
spanish = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/spanish.txt", "r")
eng = english.readlines()
spn = spanish.readlines()


def changeToBit(index, lang):
    bin = []
    test = np.array((np.zeros((30,8))))
    if lang == 1:  #english
        for x in range(len(eng[index])):
             bin = format(ord(eng[index][x]),'b')  # convert to binary starts at 97
             for y in range(len(bin)):
                 test[x][y] =  bin[y]
        return test
    else:          #spanish
        for x in range(len(spn[index])):
             bin = format(ord(spn[index][x]),'b')  # convert to binary starts at 97
             for y in range(len(bin)):
                 test[x][y] =  bin[y]
        return test

e = np.array(np.zeros((20000,30,8)))
s = np.array(np.zeros((20000,30,8)))

for i in range(20000):
    b = changeToBit(i,1)
    e[i] = b

    b = changeToBit(i,0)
    s[i] = b


train_in = np.array(np.zeros((20000,30,8)))
train_out = np.array(np.zeros((20000,1)))
val_in = np.array(np.zeros((20000,30,8)))
val_out = np.array(np.zeros((20000,1)))

for x in range(0,10000,2):
    train_in[x] = e[x]
    train_out[x] = 0
    train_in[x+1] = s[x]
    train_out[x+1] = 1

    val_in[x] = e[x+10000]
    val_out[x] = 0
    val_in[x+1] = s[x+10000]
    val_out[x+1] = 1




def network():
    model = keras.Sequential()
    model.add(keras.layers.Flatten(input_shape = (30,8)))
    model.add(keras.layers.Dense(10, activation = tf.nn.relu))
    model.add(keras.layers.Dense(10, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='binary_crossentropy',
              metrics=['accuracy'])
    history = model.fit(train_in,
                    train_out,
                    epochs=40,
                    batch_size=512,
                    validation_data=(val_in, val_out),
                    verbose=1)

network()
