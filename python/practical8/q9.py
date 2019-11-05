#list

def countWordsBegin(wList, letter):
    count = 0
    for w in wList:
        if w.startswith(letter):
            count += 1
    return count


    
wordList = ["apple", "cat", "dog", "caterpillar", "ant","apple", "cow", "donkey", "camel", "ash" ]  #create  list
letter = "c"
noOfWds = countWordsBegin(wordList, letter) 

print("No of words beginning with %s : %d " % (letter , noOfWds))

##
##i = 1
##while i <= 10:
##    word = input("Enter word %d : " % i  )
##    if word not in wordList:
##        wordList.append(word)
##        i = i + 1
##    else:
##        print(" already in list  " )
##       


##print values
#print("Word List: " , wordList)
