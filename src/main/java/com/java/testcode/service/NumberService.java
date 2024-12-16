package com.java.testcode.service;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public int findSecondLargest(int[] nums) {
        //tidak perlu melakukan pengecekan isi array
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public int findSecondLargestv2(int[] nums) {
        //v2 melakukan pengecekan kembali isi array
        if (nums == null || nums.length < 2) {
            return -1; // Tidak valid jika kurang dari 2 elemen
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // Kembalikan -1 jika tidak ada angka kedua terbesar yang valid
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

}
