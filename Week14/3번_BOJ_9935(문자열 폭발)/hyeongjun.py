s = input()
b = input()
lenb = len(b)
stack = []
for i in s:
    stack.append(i)
    if ''.join(stack[-lenb:]) == b:
        for i in range(lenb):
            stack.pop()
print(''.join(stack)) if stack else print('FRULA')