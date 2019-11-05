

def sumWithoutHighest(values):
    highest = values[0]
    total = 0
    for v in values:
        if v > highest:
            highest = v
        total += v
    return total - highest   


    
nums = [10,10,10,10,10,11]  
totalLessHighest = sumWithoutHighest(nums)
print("Total of list less Highest value: " , totalLessHighest)



