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
    if lang == 1:  #english
        for x in eng[index]:
             bin.append(list(format(ord(x),'b')))  # convert to binary starts at 97
        bin = map(int, bin)
        return bin
    else:          #spanish
        for x in spn[index]:
             bin.append(list(format(ord(x),'b')))  # convert to binary starts at 97
        return bin
e = np.array(np.zeros((20000,20,7)))

for i in range(20000):
    e[i] = changeToBit(i,0)
    for j in range(len(e[i])):
        e[i][j] = map (int, e[i][j])
    e[i].flatten()

    spn[i] = changeToBit(i,0)
    for j in range(len(spn[i])):
        spn[i][j] = map (int, spn[i][j])

print e[0]

eng_train = eng[:10000]
eng_val = eng[10000:20000]
spn_train = eng[:10000]
spn_val = eng[10000:20000]


def network():
    model = keras.Sequential()
    model.add(keras.layers.Flatten(140, 16))
    model.add(keras.layers.Dense(10, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
    model.summary()

network()
