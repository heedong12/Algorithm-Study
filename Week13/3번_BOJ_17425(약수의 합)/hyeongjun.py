MAX = 10 ** 6

prime = [True] * (MAX + 1)
prime[0] = prime[1] = False
primes = []
for i in range(2, MAX + 1):
    if prime[i]:
        primes.append(i)
        for j in range(i * i, MAX + 1, i):
            prime[j] = False

def solve(n):
    temp = n
    result = 1
    for p in primes:
        if p * p > temp:
            break
        if temp % p == 0:
            exp = 0
            while temp % p == 0:
                temp //= p
                exp += 1
            result *= (p ** (exp + 1) - 1) // (p - 1)
    if temp > 1:
        result *= (temp ** 2 - 1) // (temp - 1)
    return result


div = [0] * (MAX + 1)
for i in range(1, MAX + 1):
    div[i] = div[i - 1] + solve(i)

t = int(input())
for _ in range(t):
    n = int(input())
    print(div[n])
