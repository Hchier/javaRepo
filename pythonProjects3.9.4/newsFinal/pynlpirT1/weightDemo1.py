import xlrd
import xlwt
import jieba.posseg
from collections import Counter

str1 = ''
for i in range(0, 1201):
    str = str + sheet.cell_value(rowx = i, colx = 0)

for i in range(798977, 824946): # 836075
    path = 'E:\Hchier\THUCNews\财经' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 798977) / (836075 - 798977) * 100)

for i in range(481650, 595700): # 644578
    path = 'E:\Hchier\THUCNews\科技' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 481650) / (595700 - 481650) * 100)

for i in range(264410, 278445): # 284460
    path = 'E:\Hchier\THUCNews\房产' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 264410) / (278445 - 264410) * 100)


for i in range(284460, 313815): # 326396
    path = 'E:\Hchier\THUCNews\教育' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 284460) / (313815 - 284460) * 100)


for i in range(0, 105282): # 131603  0.8
    path = 'E:\Hchier\THUCNews\体育' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 0) / (105282 - 0) * 100)

for i in range(406428, 425926):  # 430801   0.8
    path = 'E:\Hchier\THUCNews\游戏' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 406428) / (425926 - 406428) * 100)

for i in range(131604, 205709):  # 224235   0.8
    path = 'E:\Hchier\THUCNews\娱乐' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 131604) / (205709 - 131604) * 100)


for i in range(339764, 340040):  # 340040   0.8
    # path = 'E:' + '\\' + 'Hchier' + '\\' + 'THUCNews\军事' + '\\' + str(i) + '.txt'
    path = 'E:\Hchier\THUCNews\时政' + '\\' + str(i) + '.txt'
    file1 = open(path, 'r', encoding='UTF-8')
    str1 += file1.read()
    print((i - 339764) / (340040 - 339764) * 100)

items = []
items_all = jieba.posseg.cut(str1)
i_item = 0
for item in items_all:
    if (item.flag == 'n' or
        item.flag == 'nr' or item.flag == 'ns' or
        item.flag == 'nt' or
        item.flag == 'nz' or item.flag == 'vn') \
            and len(item.word) > 1:
        i_item += 1
        print(i_item)
        # if (item.flag == 'n' or item.flag == 'v' or
        #     item.flag == 'nr' or item.flag == 'ns' or
        #     item.flag == 'nt' or
        #     item.flag == 'nz' or item.flag == 'vg' or item.flag == 'vn') \
        #         and len(item.word) > 1:
        items.append(item.word)

excle = xlwt.Workbook(encoding="utf-8")
sheet1 = excle.add_sheet("finance", cell_overwrite_ok=True)

i1 = 0
sum1 = 0
for c in Counter(items).most_common(300):
    sum1 += c[1]
print("sum1", sum1)
for c in Counter(items).most_common(300):
    for j in range(0, 2):
        sheet1.write(i1, j + 3, c[j])
    sheet1.write(i1, 5, int(c[1]) / sum1)
    print("int(c[1])", int(c[1]))
    i1 += 1

i2 = 0
sum2 = 0
for c in Counter(items).most_common(50):
    sum2 += c[1]
print(sum2)
for c in Counter(items).most_common(50):
    for j in range(0, 2):
        sheet1.write(i2, j + 15, c[j])
    sheet1.write(i2, 17, int(c[1]) / sum2)
    i2 += 1
excle.save("../finance.xls")
