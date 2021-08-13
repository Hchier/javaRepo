import xlrd
import xlwt

import jieba.posseg
from collections import Counter

items = []

# file1 = open(r'E:\Hchier\pythonProjects3.9.4\newsFinal\pynlpirT1\111.txt', 'r', encoding = 'UTF-8')
# str1=file1.read()
str1 = '深圳卫视'
print(str1)
items_all = jieba.posseg.cut(str1)
for item in items_all:
    print(item)
for item in items_all:
    if (item.flag == 'n' or
        item.flag == 'nr' or item.flag == 'ns' or
        item.flag == 'nt' or item.flag == 'nz') and len(item.word) > 1:
        print(item.word, item.flag)
