import numpy as np
import sklearn.model_selection as model_selection

if __name__ == '__main__':


    a = np.array(range(1,11))
    b = a**2

    print(a)
    print(b)

    X_train, X_test, y_train, y_test = model_selection.train_test_split(a, b, train_size=0.75, test_size=0.25,
                                                                        random_state=101)

    print(X_train)