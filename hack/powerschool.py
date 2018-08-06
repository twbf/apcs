import requests
import os

url = "https://premier.k12northstar.org/public/home.html"

start = 141556 #my s-number

for i in range(1):
     s_num = "s" + str(start)
     r = requests.post(url, data = {'account':s_num, "pw":s_num})
     print(r.content)
