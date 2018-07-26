

import math
import numpy as np
from random import *

english = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/english.txt", "r")
spanish = open("/Users/thomasbueler-faudree/GitHub/apcs/ml/eng-span/spanish.txt", "r")
eng = english.readlines()
spn = spanish.readlines()


def changeToBit(index, lang):
    if lang == 1:  #english
        for x in eng[index]:
            print format(ord(x),'b')  # convert to binary starts at 97
    else:          #spanish
        print "h"

changeToBit(4,1)

print len(spn)

print "hh"
