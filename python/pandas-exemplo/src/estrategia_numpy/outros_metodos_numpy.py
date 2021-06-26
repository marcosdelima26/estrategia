import numpy as np



if __name__ == "__main__":

    # array 1d
    a = np.arange(10)
    print(a)
    print(a.shape)
    print(a.ndim)

    #array 2d
    a = np.arange(10).reshape(2,5)
    print(a)
    print(a.shape)
    print(a.ndim)

    #array 3d
    a = np.arange(24).reshape(2, 3, 4)
    print(a)
    print(a.shape)
    print(a.ndim)


    # zeros = np.zeros((4,5))
    # print(zeros)
    # print(zeros.ndim)

    #start, stop step
    # print(np.arange(10, 30, 5))

    a = np.array([1, 2, 3, 4])
    b = np.array([5, 6, 7, 8])

    print(np.concatenate((a,b)))


    a = np.array([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])



