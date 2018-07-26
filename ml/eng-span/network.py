

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
             bin.append(format(ord(x),'b'))  # convert to binary starts at 97
        return bin
    else:          #spanish
        for x in spn[index]:
             bin.append(format(ord(x),'b'))  # convert to binary starts at 97
        return bin

print changeToBit(0,0)
