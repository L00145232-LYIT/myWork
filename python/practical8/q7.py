#list



    
wordList = []  #create  list
i = 1
while i <= 10:
    word = input("Enter word %d : " % i  )
    if word not in wordList:
        wordList.append(word)
        i = i + 1
    else:
        print(" already in list  " )
       


##print values
print("Word List: " , wordList)
