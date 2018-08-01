import tensorflow as tf
from tensorflow import keras
import numpy as np
import math
import random

file_path = "/Users/thomasbueler-faudree/GitHub/mldata/1-billion-word-language-modeling-benchmark-r13output/training-monolingual.tokenized.shuffled/"

data = open (file_path + "news.en-00001-of-00100", "r")

data = data.read().split()

num_words = 100
emb_size = 100
batch_size = 256

train_in = []
train_out = []

for x in range(num_words-1):
    if data[x-1]:
        train_in.append(data[x])
        train_out.append(data[x-1])
    if data[x+1]:
        train_in.append(data[x])
        train_out.append(data[x+1])

embeddings = tf.Variable(tf.random_uniform([num_words, emb_size], -1.0, 1.0))

nce_weights = tf.Variable(tf.truncated_normal([num_words, emb_size], stddev=1.0 / math.sqrt(emb_size)))
nce_biases = tf.Variable(tf.zeros([num_words]))

train_inputs = tf.placeholder(tf.int32, shape=[batch_size])
train_labels = tf.placeholder(tf.int32, shape=[batch_size, 1])

embed = tf.nn.embedding_lookup(embeddings, train_inputs)

loss = tf.reduce_mean(
  tf.nn.nce_loss(weights=nce_weights,
                 biases=nce_biases,
                 labels=train_labels,
                 inputs=embed,
                 num_sampled=num_sampled,
                 num_classes=vocabulary_size))
optimizer = tf.train.GradientDescentOptimizer(learning_rate=1.0).minimize(loss)

for inputs, labels in generate_batch(...):
  feed_dict = {train_inputs: inputs, train_labels: labels}
  _, cur_loss = session.run([optimizer, loss], feed_dict=feed_dict)


for x in range(100):
    print train_in[x] + ', ' + train_out[x]
