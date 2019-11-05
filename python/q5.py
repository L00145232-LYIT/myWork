

def alternatingSum(values):
    add = True
    total = 0
    for v in values:
        if add:
            total += v
        else:
            total -= v
        add = not add 
    return total    
                     
nums = [1,4,9,16,9,7,4,9,11]
total  = alternatingSum(nums)
print("Total alternating add and subtract: " , total)
