#import tensorflow as tf
#from tensorflow import keras
import numpy as np

file_path = "/Users/thomasbueler-faudree/GitHub/mldata/1-billion-word-language-modeling-benchmark-r13output/training-monolingual.tokenized.shuffled/"

data = open (file_path + "news.en-00001-of-00100", "r")

data = data.read().split()
data = map(str.lower, data)


num_words = 100
dem_size = 100
train_in = []
train_out = []
for x in range(num_words-1):
    if data[x-1]:
        train_in.append(data[x])
        train_out.append(data[x-1])
    if data[x+1]:
        train_in.append(data[x])
        train_out.append(data[x+1])

#I need two dictionaries to look up words to embedings

embeddings = np.array(np.zeros((num_words,dem_size)))


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
                    batch_size=200,
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

print('Data size', len(data))
