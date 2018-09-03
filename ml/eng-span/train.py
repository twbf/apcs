#Given a list of spanish and english words it learns the differences between english and spanish words

# anything that ends in size is a constant

import tensorflow as tf
from tensorflow import keras
import math
import numpy as np
import random
import os

english = open("apcs/ml/eng-span/text_data/english3.txt", "r")
spanish = open("apcs/ml/eng-span/text_data/spanish.txt", "r")
english = english.readlines()
spanish = spanish.readlines()
eng = list(set(english)-set(spanish))
spn = list(set(spanish)-set(english))
print(english[0])
print(eng[2])
#random.shuffle(eng)
#random.shuffle(spn)

eng_size = len(eng)
spn_size = len(spn)
total = eng_size+spn_size
val_size = 10000

t_size = total-val_size
word_size = 18

def changeToBit(index, lang):
    if lang == 0:
        C=eng[index]
    else:
        C=spn[index]
    bin = []
    test = np.array((np.zeros((word_size,8))))
    word_length = len(C)-1
    if word_length>word_size:
        word_length=word_size
    for x in range(word_length):
         bin = format(ord(C[x]),'b')  # convert to binary starts at 97
         for y in range(len(bin)):
             test[x][y] =  bin[y]
    return test


words = np.array(np.zeros((total,word_size,8)))
words_l = np.array(np.zeros((total)))

for i in range(total):
    if i<eng_size:
        words[i] = changeToBit(i,0)
        words_l[i] = 0
    else:
        words[i] = changeToBit(i-eng_size,1)
        words_l[i] = 1

print words[2]

c = list(zip(words, words_l))
random.shuffle(c)
words, words_l = zip(*c)

train_in = np.array(np.zeros((t_size,word_size,8)))
train_out = np.array(np.zeros((t_size)))
val_in = np.array(np.zeros((val_size,word_size,8)))
val_out = np.array(np.zeros((val_size)))

for x in range(0,val_size):
    val_in[x] = words[x]
    val_out[x] = words_l[x]

for x in range(0,t_size):
    train_in[x] = words[x+val_size]
    train_out[x] = words_l[x+val_size]


def network():
    model = keras.Sequential()

    file_path = "training_2/cp.ckpt"
    directory = os.path.dirname(file_path)
    cp_callback = tf.keras.callbacks.ModelCheckpoint(file_path,
                                                 save_weights_only=True,
                                                 verbose=1)

    model.add(keras.layers.Flatten(input_shape = (word_size,8)))
    #model.add(keras.layers.Dropout(0.1))
    model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
    #model.add(keras.layers.Dropout(0.1))
    model.add(keras.layers.Dense(50, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='logcosh',
              metrics=['accuracy'])
    history = model.fit(train_in,
                    train_out,
                    epochs=3,
                    batch_size=200,
                    validation_data=(val_in, val_out),
                    #callbacks = [cp_callback],
                    verbose=1)
    model.save('apcs/ml/eng-span/model.h5')
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
