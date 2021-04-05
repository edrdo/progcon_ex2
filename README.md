[Programação Concorrente](https://www.dcc.fc.up.pt/~edrdo/aulas/pc), CC3037, DCC/FCUP

_Eduardo R. B. Marques, DCC/FCUP_


# Ficha 2

## Exemplos da aula e outros ficheiros associados

Ficheiro|Descrição|
-------|---------|
`IBoundedQueue.java`| Interface para fila de capacidade limitada e com operações bloqueantes `add()` e `remove()`.|
`BoundedQueue1.java` | Implementação de `IBoundedQueue` usando monitores para sincronização.|
`BoundedQueue2.java`| Implementação de `IBoundedQueue` usando `ReentrantLock` e variáveis de condição.|
`TestBoundedQueue` | Programa de teste.|
`D.java` | Classe utilitária para "debugging".|

## 1

Considere o esqueleto inicial para a implementação de uma stack,  disponibilizada no ficheiro `Stack1.java`.  Pretende-se que complete a implementação atendendo a que:

- A stack deverá ter a habitual disciplina LIFO ("Last In, First Out") e a operação `pop()` deverá bloquear uma thread enquanto a stack estiver vazia e portanto não seja possível remover um elemento.

- O tamanho da stack pode crescer arbitrariamente, usando internamente  um  objecto de tipo [`java.util.LinkedList`](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) para armazenar os elementos. Objectos deste tipo não são "thread-safe", uma vez que a classe `LinkedList` não tem associado qualquer mecanismo 
de sincronização entre threads.

- Pode usar o programa em `TestStack.java` para validar a sua implementação.

## 2 

Em `Stack2.java` implemente uma stack com características similares ao do exercício anterior, mas empregando uma instância de `ReentrantLock` e uma variável de condição.

## 3 

Em `Stack3.java` implemente uma terceira versão da stack, recorrendo a um objecto de tipo  [`java.util.concurrent.LinkedBoundedDeque`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBoundedDeque.html). Ao contrário de `LinkedList`, esta classe é "thread-safe".








