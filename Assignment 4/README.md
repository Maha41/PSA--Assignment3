Your task this time is to verify the Birthday Problem and the Coupon Collector's Problem. As you recall, these are both relevant to understanding how a hash table, especially one using separate chaining, will behave. But scientists, including engineers, shouldn't always just take things for granted. So, you will actually run experiments to validate the following two expressions:

 C subscript 1 left parenthesis m right parenthesis space tilde space square root of straight pi space straight m space divided by space 2 end root

 B subscript 0 left parenthesis m right parenthesis space tilde space m space ln space m

where

m is the number of bins/slots; and
C1(m) is the (average) number of hashes/throws before the first collision in encountered; and
B0(m) is the (average) number of hashes/throws before all bins/slots are filled (i.e. there are zero empty bins).
You must follow the submission guidelines previously published for these assignments. You must implement your own hash function, and the keys that you provide should be randomly chosen. You might choose random Double values, for instance. You should provide unit tests that ensure that when adding a key, the hash function operates correctly and the logic of counting balls in a bin is correct. You do not need to use the benchmark tool this time as there is no timing involved.

