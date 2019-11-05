

results = [39, 95, 45, 56, 33, 89, 99, 40, 95, 55]
print(results)


print("No of students scoring 95%: " , results.count(95))


results[len(results)-1] = 65
print(results)


print("Highest result: " , max(results))


print("lowest result: " , min(results))


ave = sum(results)/len(results)
print("average result: " , ave)


results.sort()
print("sorted increasing order:  " ,results)


results.reverse()
print("sorted decreasing order:  " ,results)



