package com.java.testcode.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public int findMissingNumber(int[] nums) {
        //angka wajib di mulai dari angka 1 / positive
        int n = nums.length + 1;
        int totalSum = n * (n + 1) / 2;
        for (int num : nums) totalSum -= num;
        return totalSum;
    }

    public int findMissingNumberFromzero(int[] nums) {
        int n = nums.length; // n adalah jumlah angka yang tersedia, jadi angka sebenarnya adalah 0 sampai n
        int totalSum = n * (n + 1) / 2; // Jumlah total dari 0 sampai n
        for (int num : nums) {
            totalSum -= num; // Kurangi setiap angka yang ada di array
        }
        return totalSum; // Sisa dari totalSum adalah angka yang hilang
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) duplicates.add(num);
        }
        return duplicates;
    }
    public int maxSubArraySum(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        System.out.println(maxSum);
        System.out.println(currentSum);
        for (int i = 1; i < nums.length; i++) {
            System.out.println(i);
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

}
