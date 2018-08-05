import tensorflow as tf
from tensorflow import keras
import numpy as np

file_path = "/Users/thomasbueler-faudree/GitHub/mldata/1-billion-word-language-modeling-benchmark-r13output/training-monolingual.tokenized.shuffled/"

data = open (file_path + "news.en-00001-of-00100", "r")

data = data.read().split()
data = map(str.lower, data)


num_words = 10000
dem_size = 100


dictionary = dict()

counter = 0

for x in range(num_words):
    if data[x] in dictionary:
        counter = counter #something
    else:
        dictionary[data[x]] = counter
        counter += 1

unq_words = len(dictionary)

_in = []
_out = []
for x in range(num_words-1):
    if data[x-1]:
        _in.append(dictionary[data[x]])
        _out.append(dictionary[data[x-1]])
    if data[x+1]:
        _in.append(dictionary[data[x]])
        _out.append(dictionary[data[x+1]])


embeddings = np.array(np.random.random((unq_words,dem_size)))
train_in = np.array(np.zeros((len(_in),dem_size)))
train_out = np.array(np.zeros((len(_out),dem_size)))

for x in range(len(_in)):
    train_in[x] = embeddings[_in[x]]

for x in range(len(_out)):
    train_out[x] = embeddings[_out[x]]

def network():
    model = keras.Sequential()
    #model.add(keras.layers.Flatten(input_shape = (dem_size)))
    model.add(keras.layers.Dense(dem_size, input_shape = (dem_size,)))
    model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
    model.add(keras.layers.Dense(dem_size, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='nce_loss',
              metrics=['accuracy'])
    history = model.fit(train_in,
                    train_out,
                    epochs=10,
                    batch_size=100,
                    #validation_data=(val_in, val_out),
                    verbose=1)
    predictions = model.predict(train_in)
    for x in range(100):
        print predictions[x]

print('Data size', len(data))
network()
