import numpy as np

if __name__ == "__main__":
    anos_nascimento = np.loadtxt('anos_de_nascimento.txt')

    # calculado a idade
    idades = 2020 - anos_nascimento
    print(idades)
    print(idades.sum())

    media = idades.sum() / idades.size
    print(media)
