 Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of book: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the books pages:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of student(number of student must be smaller or equal to number of book): ");
        int students = sc.nextInt();