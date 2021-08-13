list2 = ['a', 'c', 'a', 'a', 'a', 'b', 'a', 'a']

count1 = 0
list3 = []
for i in range(0, len(list2)):
    if list2[i] not in list3:
        count1 += 1
        list3.append(list2[i])

print(count1)
