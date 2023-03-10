
t= int(input())

while(t!=0):
  count = int(input())

# Convert the input string to a list of integers
  numbers = input()

# Convert the input string to a list of integers
  numbers = [int(num) for num in numbers.split()]


# Initialize counters for even and odd numbers
  even_count = 0
  odd_count = 0

# Loop through the list of numbers and count the even and odd ones
  for num in numbers:
    if num % 2 == 0:
        even_count += 1
    else:
        odd_count += 1

# Print the results
  t=t-1
  print(odd_count, even_count)
