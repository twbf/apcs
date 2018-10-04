import tensorflow as tf
from tensorflow import keras
import numpy as np
import math
import random
import os

file_path = "/Users/thomasbueler-faudree/GitHub/mldata/1-billion-word-language-modeling-benchmark-r13output/training-monolingual.tokenized.shuffled/"

vocabulary = open (file_path + "news.en-00001-of-00100", "r")

vocabulary = vocabulary.read().split()
vocabulary = map(str.lower, vocabulary)

print('Data size', len(vocabulary))
