import numpy as np



if __name__ == "__main__":

    c = []

    a = [2,3,4]
    b = [5,7,7]

    for i in range(len(a)):
        c.append(a[i] * b[i])

    print(c)

    num_a = np.array(a)
    num_b = np.array(b)
    num_c = num_a * num_b

    print(type(c))
    print(type(num_c))

    print(num_c)
    print(num_c.ndim)
    print(num_c.shape)
    print(num_c.size)
    print(num_c.dtype)
    print(num_c.itemsize)
    print(num_c.data)



