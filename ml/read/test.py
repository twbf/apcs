#import tensorflow as tf
#from tensorflow import keras
import numpy as np

file_path = "/Users/thomasbueler-faudree/GitHub/mldata/1-billion-word-language-modeling-benchmark-r13output/training-monolingual.tokenized.shuffled/"

data = open (file_path + "news.en-00001-of-00100", "r")

data = data.read().split()
data = map(str.lower, data)


num_words = 100
dem_size = 10


dictionary = dict()

counter = 0

for x in range(num_words):
    if data[x] in dictionary:
        counter = counter #something
    else:
        dictionary[data[x]] = counter
        counter += 1

unq_words = len(dictionary)

print unq_words

train_in = []
train_out = []
for x in range(num_words-1):
    if data[x-1]:
        train_in.append(dictionary[data[x]])
        train_out.append(dictionary[data[x-1]])
    if data[x+1]:
        train_in.append(dictionary[data[x]])
        train_out.append(dictionary[data[x+1]])

for x in range(num_words - 1):
    print train_in[x]

embeddings = np.array(np.zeros((unq_words,dem_size)))


def network():
    model = keras.Sequential()
    model.add(keras.layers.Flatten(input_shape = (dem_size)))
    model.add(keras.layers.Dense(2500, activation = tf.nn.relu))
    model.add(keras.layers.Dense(dem_size, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='logcosh',
              metrics=['accuracy'])
    history = model.fit(train_in,
                    train_out,
                    epochs=30,
                    batch_size=100,
                    validation_data=(val_in, val_out),
                    verbose=1)
    predictions = model.predict(val_in)

print('Data size', len(data))
