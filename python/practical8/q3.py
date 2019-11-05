def sumWithoutSmallest(values):
    smallest = values[0]
    total = 0
    for v in values:
        if v < smallest:
            smallest = v
        total += v
    return total - smallest   

nums = [5,2,3,4,5] 
print("Total of list less lowest value: " ,  sumWithoutSmallest(nums))

