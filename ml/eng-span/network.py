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
    e[i].flatten()
    b = changeToBit(i,0)
    s[i] = b
    s[i].flatten()

e.flatten()

print e[300]

eng_train = e[:10000]
eng_val = e[10000:20000]
spn_train = eng[:10000]
spn_val = eng[10000:20000]


def network():
    model = keras.Sequential()
    model.add(keras.layers.Flatten(140, 16))
    model.add(keras.layers.Dense(10, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
    model.summary()

network()
