import jieba
import jieba.posseg
from collections import Counter

file1 = open("../game1.txt", encoding = "UTF-8")

# for word in jieba.posseg.cut(file1.read(), cut_all = True):
#     print(word)

# items = jieba.posseg.cut(file1.read())
# for item in items:
#     print(item.word, item.flag)


items = []
items_all = jieba.posseg.cut(file1.read())
for item in items_all:
    # if (item.flag == 'n' or item.flag == 'v' or
    #     item.flag == 'nr' or item.flag == 'ns' or
    #     item.flag == 'nt' or
    #     item.flag == 'nz' or item.flag == 'vg' or item.flag == 'vn') \
    #         and len(item.word) > 1:
    if item.flag == 'n' and len(item.word) > 1:
        items.append(item.word)
for c in Counter(items).most_common(20):
    print(c)
# for item in items:
#     print(item)
