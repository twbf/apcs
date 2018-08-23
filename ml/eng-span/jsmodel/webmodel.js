
// want to load network then once network is loaded get input
// run input through network
// obtain output
// attach output to output div

import * as tf from '@tensorflow/tfjs';

const model = await tf.loadModel('jsmodel/model.json');

input = document.getElementById("input");

output = document.getElementById("output");
output.appendChild(document.createElement('p'));
