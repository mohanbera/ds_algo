num = int(input('Enter the number\n'))


def solve(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return solve(n-1) + solve(n-2) + solve(n-3)


print(solve(num))


def solve1(n):
    if n < 0:
        return 0
    elif n == 0:
        return 1
    else:
        return solve1(n-1) + solve1(n-2) + solve1(n-3)


print(solve1(num))


def solve_with_memorization(n):
    arr = [1, 2, 4]
    for i in range(3, n):
        arr.append(0)
        arr[i] = arr[i-1]+arr[i-2]+arr[i-3]

    return arr[n-1]


print(solve_with_memorization(30))
