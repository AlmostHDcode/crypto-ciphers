def LFSR_q1_2():
    """
    script that helps calculate the LFSR's in question 1
    this function made for polynomial x^5+x^2+x+1
    """
    # x^5+x^2+x+1

    print("Enter the initial state")
    s4 = int(input("s4 = "))
    s3 = int(input("s3 = "))
    s2 = int(input("s2 = "))
    s1 = int(input("s1 = "))
    s0 = int(input("s0 = "))

    initial_state = s4, s3, s2, s1, s0
    output = (((s0 ^ s1) ^ s2) ^ s4)
    state = 0
    c = 1
    print(str(c) + ":", initial_state, output)

    while state != initial_state:
        s0 = s1
        s1 = s2
        s2 = s3
        s3 = s4
        s4 = output
        output = (((s0 ^ s1) ^ s2) ^ s4)
        state = s4, s3, s2, s1, s0
        c += 1
        print(str(c) + ":", state, output)

    cycle = c - 1
    print("Cycle = ", cycle)


def LFSR_q1_3():
    """
    Script that helps calculate the LFSR's in question 1
    this function made for polynomial x^6+x+1
    """

    print("Enter the initial state")
    s5 = int(input("s5 = "))
    s4 = int(input("s4 = "))
    s3 = int(input("s3 = "))
    s2 = int(input("s2 = "))
    s1 = int(input("s1 = "))
    s0 = int(input("s0 = "))

    initial_state = s5, s4, s3, s2, s1, s0
    output = (s0 ^ s1)
    state = 0
    c = 1
    print(str(c) + ":", initial_state, output)

    while state != initial_state:
        s0 = s1
        s1 = s2
        s2 = s3
        s3 = s4
        s4 = s5
        s5 = output
        output = (s0 ^ s1)
        state = s5, s4, s3, s2, s1, s0
        c += 1
        print(str(c) + ":", state, output)

    cycle = c - 1
    print("Cycle = ", cycle)


if __name__ == '__main__':
    #LFSR_q1_2()
    LFSR_q1_3()
