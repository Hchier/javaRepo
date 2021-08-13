file1 = open(r'E:\Desktop\111.txt', 'r', encoding='UTF-8')
str1 = file1.read()
print(str1)

for i in range(798977, 836075):
    path = 'E:\Hchier\THUCNews\财经'+'\\'+str(i)+'.txt'
    file1 = open(path, 'r', encoding='UTF-8')

