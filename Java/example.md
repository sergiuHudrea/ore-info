1234321

1b = (1234321 % 10) / 1
1f = (1234321 / (10 ** 6)) % 10

2b = (1234321 % 100) / 10
2f = (1234321 / (10 ** 5)) % 10

3b = (1234321 % 1000) / 100
3f = (1234321 / 10 ** 4) % 10


stop: nrCifre // 2


---

## CMMDC


a = 32

b = 24

n = a --> 32

m = b --> 24

Pas 1

n = n - m --> 8

Pas 2

m = m - n --> 16

Pas 3

m = m - n --> 8

pas 4

m = n

return m

---
Mos Craciun problema
n = 1428429, p = 2, k = 3  --> 4128924

c = 7
4 = (n / (10 ** 5)) % 10
1 = (n / (10 ** 6)) % 10
st = (4 * (10 ** 1) + 1 * (10 ** 0)) * (10 ** 5)

4 = (n / (10 ** (c - p))) % 10
1 = (n / (10 ** (c - p + 1))) % 10
st = (4 * (10 ** (p - 1)) + 1 * (10 ** (p - 2))) * (10 ** (c - p))

lMij = c - (p + k)
mij = (n / (10 ** k)) % (10 ** lMij)


9 = (n / (10 ** 0)) % 10 
2 = (n / (10 ** 1)) % 10
4 = (n / (10 ** 2)) % 10
dr = (9 * (10 ** 2)) + (2 * (10 ** 1)) + (4 * (10 ** 0))

r = st + mij + dr

---

Sir 11

1, -1, 2, ...

f(0) = 1
f(1) = −1
f(n) = 1 − 2 ⋅ f(n−1) − f(n−2)

f(3) = 1 - 2 * 2 - (-1)
f(3) = -2



---

## Diference Arrays
A = 5, 2, 3, 12
D = 5, -7, 5, 9, 0
D = A[0], A[1] - A[0], A[2] - A[1], A[3] - A[2]
l = 0, r = 1, val = 10

D = 15, -7, -5, 9, 0
D = A[0] + 10, A[1] - A[0], A[2] - A[1] - 10, A[3] - A[2]

print A
A[0] = A[0] + 10 = 15
A[1] = A[1] - A[0] + A[0] + 10 = A[1] + 10 = 12
A[2] = A[2] - A[1] - 10 + A[1] + 10 = A[2] = 3
A[3] = A[3] - A[2] + A[2] = A[3] = 12

l = 1, r = 3, val = 20
D = 15, 13, -5, 9, -20
D = A[0] + 10, A[1] - A[0] + 20, A[2] - A[1] - 10, A[3] - A[2], -20

print A
A[0] = A[0] + 10 = 5 + 10
A[1] = A[1] - A[0] + 20 + A[0] + 10 = A[1] + 30 = 2 + 30 = 32
A[2] = A[2] - A[1] - 10 + A[1] + 20 + 10 = A[2] + 20 = 23
A[3] = A[3] - A[2] + A[2] + 20 = A[3] + 20 = 32

---

124, 229, 1322, 4, 534

vectorFrecv = {0, 2, 5, 2, 3, 1, 0, 0, 0, 1}
vectorCara =  {1, 0, 0, 0, 0, 0, 1, 1, 1, 0}

1.
k = 0, indexMin = 0, valMin = 0

indexMin = 1, valMin = 2
indexMin = 5, valMin = 1
out: 5
vectorCara =  {1, 0, 0, 0, 0, 1, 1, 1, 1, 0}

2.
k = 1, indexMin = 0, valMin = 2
indexMin = 1, valMin = 2

valMin = 2
indexMin = 9, valMin = 1
out: 9
vectorFrecv = {0, 2, 5, 2, 3, 1, 0, 0, 0, 1}
vectorCara =  {1, 0, 0, 0, 0, 1, 1, 1, 1, 1}

3.
k = 2, indexMin = 0, valMin = 0

indexMin = 1, valMin = 2
indexMin = 1, valMin = 2
out: 1
vectorFrecv = {0, 2, 5, 2, 3, 1, 0, 0, 0, 1}
vectorCara =  {1, 1, 0, 0, 0, 1, 1, 1, 1, 1}

4.
k = 3, indexMin = 0
indexMin = 2
valMin = 5
indexMin = 3, valMin = 2
out: 3
vectorFrecv = {0, 2, 5, 2, 3, 1, 0, 0, 0, 1}
vectorCara =  {1, 1, 0, 1, 0, 1, 1, 1, 1, 1}

5.
k = 4, indexMin = 0
indexMin = 2
valMin = 5
indexMin = 4, valMin = 3
out: 4
vectorFrecv = {0, 2, 5, 2, 3, 1, 0, 0, 0, 1}
vectorCara =  {1, 1, 0, 1, 1, 1, 1, 1, 1, 1}

