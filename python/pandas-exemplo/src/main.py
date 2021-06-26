import numpy as np
import pandas as pd


def say_hello(nome):
    return f'Olá {nome}, seja bem-vindo!'


def criar_serie():
    return pd.Series(["raphael", "matheus", "paula"], [1,2,3])


if __name__ == "__main__":
    msg = say_hello("Raphael")
    print(msg)
