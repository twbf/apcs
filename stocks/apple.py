#import tensorflow as tf
#from tensorflow import keras
import math
import numpy as np
import random
import os
import csv

with open('AAPL_data.csv', newline='') as csvfile:
    data = list(csv.reader(csvfile))

data = array(data)
print(len(data))

def network():
        model = keras.Sequential()
        model.add(keras.layers.Flatten(input_shape = (5,5)))
        model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
        model.add(keras.layers.Dense(100, activation = tf.nn.relu))
        model.add(keras.layers.Dense(1, activation = tf.nn.sigmoid))
        model.summary()
        model.compile(optimizer=tf.train.AdamOptimizer(),
                  loss='logcosh',
                  metrics=['accuracy'])
        history = model.fit(train_in,
                        train_out,
                        epochs=100,
                        batch_size=200,
                        validation_data=(val_in, val_out),
                        #callbacks = [cp_callback],
                        verbose=1)

network();
