import tensorflow as tf
from tensorflow import keras
import numpy as np
import math

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

embed = tf.nn.embedding_lookup(embeddings, _in)
with tf.name_scope('weights'):
  nce_weights = tf.Variable(
      tf.truncated_normal(
          [unq_words, dem_size],
          stddev=1.0 / math.sqrt(dem_size)))
with tf.name_scope('biases'):
  nce_biases = tf.Variable(tf.zeros([unq_words]))

with tf.name_scope('loss'):
    loss = tf.reduce_mean(
        tf.nn.nce_loss(
            weights=nce_weights,
            biases=nce_biases,
            labels=_out,
            inputs=embed,
            num_sampled=num_sampled,
            num_classes=unq_words))
    tf.summary.scalar('loss', loss)

  # Construct the SGD optimizer using a learning rate of 1.0.
with tf.name_scope('optimizer'):
    optimizer = tf.train.GradientDescentOptimizer(1.0).minimize(loss)

# Compute the cosine similarity between minibatch examples and all embeddings.
    norm = tf.sqrt(tf.reduce_sum(tf.square(embeddings), 1, keepdims=True))
    normalized_embeddings = embeddings / norm
    valid_embeddings = tf.nn.embedding_lookup(normalized_embeddings,
                                        valid_dataset)
    similarity = tf.matmul(
    valid_embeddings, normalized_embeddings, transpose_b=True)

# Merge all summaries.
    merged = tf.summary.merge_all()

# Add variable initializer.
    init = tf.global_variables_initializer()

def network():
    model = keras.Sequential()
    #model.add(keras.layers.Flatten(input_shape = (dem_size)))
    model.add(keras.layers.Dense(dem_size, input_shape = (dem_size,)))
    model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
    model.add(keras.layers.Dense(1000, activation = tf.nn.relu))
    model.add(keras.layers.Dense(dem_size, activation = tf.nn.sigmoid))
    model.summary()
    model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='logcosh',
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
