/**
 * @author Vijay
 * @author Chadra
 * @author Christ
 * */
package org.group17_cs4050_assignment1;

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel {


    // An array to hold the lines_lengths to be sorted
    public int[] lines_lengths;
    //The amount of lines needed
    public final int total_number_of_lines = 256;
    // An array to holds the scrambled lines_lengths
    public int[] scramble_lines;
    //A temp Array that is used later for sorts
    public int[] tempArray;

    //the default constructor for the SortShow class
    public SortShow() {
        //assigning the size for the lines_lengths below
        lines_lengths = new int[total_number_of_lines];
        for (int i = 0; i < total_number_of_lines; i++)
            lines_lengths[i] = i + 5;

    }


    //A method that scrambles the lines
    public void scramble_the_lines() {
        //A random generator
        Random num = new Random();
        //Randomly switching the lines
        for (int i = 0; i < total_number_of_lines; i++) {
            //getting a random number using the nextInt method (a number between 0 to i + 1)
            int j = num.nextInt(i + 1);
            //swapping The element at i and j
            swap(i, j);
        }
        //assigning the size for the scramble_lines below
        scramble_lines = new int[total_number_of_lines];
        //copying the now scrambled lines_lengths array into the scramble_lines array
        //to store for reuse for other sort methods
        //so that all sort methods will use the same scrambled lines for fair comparison
        for (int i = 0; i < total_number_of_lines; i++) {
            scramble_lines[i] = lines_lengths[i];
        }
        //Drawing the now scrambled lines_lengths
        paintComponent(this.getGraphics());
    }

    //Swapping method that swaps two elements in the lines_lengths array
    public void swap(int i, int j) {
        //storing the i element in lines_lengths in temp
        int temp = lines_lengths[i];
        //giving i element in lines_lengths the value of j element in lines_lengths
        lines_lengths[i] = lines_lengths[j];
        //giving j element in lines_lengths the value of temp
        lines_lengths[j] = temp;
    }

    //////////////////////////////// BUBBLE SORT ///////////////////////////////////////////////////

    /**
     * Initiates the bubble sort algorithm to sort an array
     * and calculates the time taken to perform the sort. The sort results are visually updated
     * on a GUI component. The time taken for the sort operation is stored in a static variable
     * of the SortGUI class for further use or display.
     */
    public  void BubbleSort(){
        // Capture the start time of the sort operation
        Calendar start = Calendar.getInstance();
        // Call the BubbleSort method with the total number of lines to sort
        BubbleSort(total_number_of_lines);
        // Capture the end time of the sort operation
        Calendar end = Calendar.getInstance();
        // Calculate the time taken for the bubble sort and store it in a static variable of SortGUI class
        SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();

    }

    /**
     * Performs the bubble sort algorithm recursively array named 'lines_lengths'
     * which contains lengths of lines to be sorted.
     *
     * @param n The number of elements in the array that need to be sorted in the current recursion step.
     */
    public void BubbleSort(int n){
        // Check if the array has more than one element to sort
       if(n>1){
           // Perform one pass of bubble sort
           for(int i=0;i<n-1;i++){
               // If the current element is greater than the next one, swap them
               if(lines_lengths[i]>lines_lengths[i+1]){
                   swap(i,i+1);
               }
           }
           // Repaint the component to visually represent the current state of the array with 10 ms delay
           paintComponent(this.getGraphics());
           delay(10);

           // Recursive call to bubble sort the array with one less element
           BubbleSort(n-1);
       }
    }


    //////////////////////////////// SELECTION SORT ///////////////////////////////////////////////////
    //The selectionSort method
    public void SelectionSort() {
        //getting the date and time when the selection sort starts
        Calendar start = Calendar.getInstance();
        //Using the selection sort to lines_lengths sort the array

        //You need to complete this part.
        for (int index = 0; index < total_number_of_lines - 1; index++) {
            //redrawing the lines_lengths
            int indexOfNextSmallest = getIndexOfSmallest(index, total_number_of_lines - 1);
            swap(index, indexOfNextSmallest);
            paintComponent(this.getGraphics());
            delay(10);
        }

        //getting the date and time when the selection sort ends
        Calendar end = Calendar.getInstance();
        //getting the time it took for the selection sort to execute
        //subtracting the end time with the start time
        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
    }

    /**
     * Returns the index of the smallest element in a subset of the 'lines_lengths' array.
     *
     * @param first The start index of the range to search, inclusive.
     * @param last The end index of the range to search, inclusive.
     * @return The index of the smallest element within the specified range.
     *
     * Example:
     * Given an array 'lines_lengths' with values [5, 2, 3, 1, 4], calling getIndexOfSmallest(1, 3)
     * would return 3, as the element at index 3 (value 1) is the smallest in the range 1 to 3.
     */
    public int getIndexOfSmallest(int first, int last) {
        // Initialize the minimum value with the element at the starting index 'first'
        int min = lines_lengths[first];
        // Initialize the index of the minimum element with the starting index 'first'
        int indexOfMin = first;
        // Loop through the array starting from the next element after 'first' up to 'last'
        for (int index = first + 1; index <= last; index++) {
            //If the current element is smaller than the current minimum
            if (lines_lengths[index] < min) {
                // Update the minimum value to the current element's value
                min = lines_lengths[index];
                // Update the index of the minimum element to the current index
                indexOfMin = index;
            }
        }
        // Return the index of the smallest element found in the specified range
        return indexOfMin;
    }


    //////////////////////////////// INSERTION SORT ///////////////////////////////////////////////////
    /**
     * Performs an insertion sort on a array `lines_lengths` which contains
     * integer values representing the lengths of lines. The sorting process is timed, and the
     * duration is stored in the `SortGUI.insertionTime` static variable. This method is designed
     * to sort the entire array in ascending order.
     */
    public void InsertionSort(){
        // Record the start time of the sorting process.
        Calendar start = Calendar.getInstance();
        // Perform the sorting operation on the entire array.
        insertionSort(0,total_number_of_lines-1);
        // Record the end time of the sorting process.
        Calendar end = Calendar.getInstance();
        // Calculate the duration of the sorting process and store it.
        SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
    }

    /**
     * Recursively sorts a segment of the `lines_lengths` array using the insertion sort algorithm.
     *
     * @param first The starting index of the segment to be sorted.
     * @param last The ending index of the segment to be sorted.
     */
    public void insertionSort(int first,int last){
        // Base case: if the segment to sort has more than one element
        if(first<last){
            // Recursively sort the segment from first to last-1
            insertionSort(first,last-1);
            // Insert the last element of the segment into its correct position
            // within the sorted array from first to last-1.
            insertInOrder(lines_lengths[last],first,last-1);
            // Update the GUI to visually represent the current state of the array with 10 ms delay
            paintComponent(this.getGraphics());
            delay(10);
        }
    }

    /**
     * Inserts an element into its correct position within a sorted segment of the `lines_lengths` array.
     *
     * @param removedElement The element to be inserted into the sorted segment.
     * @param begin The starting index of the sorted segment.
     * @param end The ending index of the sorted segment.
     */
    public void insertInOrder(int removedElement,int begin,int end){
        // Check if the element to insert is greater than or equal to the last element of the sorted segment
        if(removedElement>=lines_lengths[end]){
            // Place the element directly after the last element of the sorted segment
            lines_lengths[end+1]=removedElement;
        }
        else{
            // Shift the last element of the sorted segment one position to the right
            lines_lengths[end+1]=lines_lengths[end];
            // If there are more elements in the sorted segment, recursively find the correct position
            if(begin<end){
                insertInOrder(removedElement,begin,end-1);
            }
            else{
                // Place the element at the beginning of the sorted segment
                lines_lengths[end]=removedElement;
            }
        }
    }



    ///////////////////////////////////////////////////////////////////////////////////

    //recursive merge sort method
    public void R_MergeSort() {
        //getting the date and time when the recursive merge sort starts
        Calendar start = Calendar.getInstance();
        //assigning the size for the tempArray below

        //You need to complete this part.
        tempArray = new int[total_number_of_lines];

        R_MergeSort(0,total_number_of_lines-1);

        Calendar end = Calendar.getInstance();
        //getting the time it took for the iterative merge sort to execute
        //subtracting the end time with the start time
        SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();

    }

    //recursive merge sort method
    public void R_MergeSort(int first, int last) {
        if (first < last) {
            int middle=(first+last)/2;

            //sort first and second half
            R_MergeSort(first,middle);
            R_MergeSort(middle+1,last);

            // merge
            R_Merge(first,middle,last);
            paintComponent(this.getGraphics());

            //Causing a delay for 10ms
            delay(10);
        }
    }

    //recursive merge sort method
    public void R_Merge(int first, int mid, int last) {
        int beginFirstHalf= first;
        int beginSecondHalf=mid+1;
        int index=first;
        while(beginFirstHalf<=mid && beginSecondHalf<=last){
           if(lines_lengths[beginFirstHalf]<lines_lengths[beginSecondHalf]){
               tempArray[index]=lines_lengths[beginFirstHalf];
               beginFirstHalf++;
           }
           else{
               tempArray[index]=lines_lengths[beginSecondHalf];
               beginSecondHalf++;
           }
           index++;
        }

        //copy remaining elements from first half
        while(beginFirstHalf<=mid){
            tempArray[index]=lines_lengths[beginFirstHalf];
            beginFirstHalf++;
            index++;
        }

        //copy remaining elements from second half
        while(beginSecondHalf<=last){
            tempArray[index]=lines_lengths[beginSecondHalf];
            beginSecondHalf++;
            index++;
        }

        //copy elements from temp array to original array
        for (int i = first; i <= last; i++) {
            lines_lengths[i] = tempArray[i];
        }

    }

    //

    //////////////////////////////////////////////////////////////////////////////////////////

    //iterative merge sort method
    public void I_MergeSort() {
        //getting the date and time when the iterative merge sort starts
        Calendar start = Calendar.getInstance();
        //assigning the size for the tempArray below
        tempArray = new int[total_number_of_lines];
        //saving the value of total_number_of_lines
        int beginLeftovers = total_number_of_lines;


        for (int segmentLength = 1; segmentLength <= total_number_of_lines / 2; segmentLength = 2 * segmentLength) {
            beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
            int endSegment = beginLeftovers + segmentLength - 1;
            if (endSegment < total_number_of_lines - 1) {
                I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
            }
        }

        // merge the sorted leftovers with the rest of the sorted array
        if (beginLeftovers < total_number_of_lines) {
            I_Merge(0, beginLeftovers - 1, total_number_of_lines - 1);
        }
        //getting the date and time when the iterative merge sort ends
        Calendar end = Calendar.getInstance();
        //getting the time it took for the iterative merge sort to execute
        //subtracting the end time with the start time
        SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
    }

    // Merges segments pairs (certain length) within an array
    public int I_MergeSegmentPairs(int l, int segmentLength) {
        //The length of the two merged segments

        //You suppose  to complete this part (Given).
        int mergedPairLength = 2 * segmentLength;
        int numberOfPairs = l / mergedPairLength;

        int beginSegment1 = 0;
        for (int count = 1; count <= numberOfPairs; count++) {
            int endSegment1 = beginSegment1 + segmentLength - 1;

            int beginSegment2 = endSegment1 + 1;
            int endSegment2 = beginSegment2 + segmentLength - 1;
            I_Merge(beginSegment1, endSegment1, endSegment2);

            beginSegment1 = endSegment2 + 1;
            //redrawing the lines_lengths
            paintComponent(this.getGraphics());
            //Causing a delay for 10ms
            delay(10);
        }
        // Returns index of last merged pair
        return beginSegment1;
        //return 1;//modify this line
    }

    public void I_Merge(int first, int mid, int last) {
        //You suppose  to complete this part (Given).
        // Two adjacent sub-arrays
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        // While both sub-arrays are not empty, copy the
        // smaller item into the temporary array
        int index = beginHalf1; // Next available location in tempArray
        for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) {
            // Invariant: tempArray[beginHalf1..index-1] is in order
            if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2]) {
                tempArray[index] = lines_lengths[beginHalf1];
                beginHalf1++;
            } else {
                tempArray[index] = lines_lengths[beginHalf2];
                beginHalf2++;
            }
        }
        //redrawing the lines_lengths
        paintComponent(this.getGraphics());

        // Finish off the nonempty sub-array

        // Finish off the first sub-array, if necessary
        for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
            // Invariant: tempArray[beginHalf1..index-1] is in order
            tempArray[index] = lines_lengths[beginHalf1];

        // Finish off the second sub-array, if necessary
        for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
            // Invariant: tempa[beginHalf1..index-1] is in order
            tempArray[index] = lines_lengths[beginHalf2];

        // Copy the result back into the original array
        for (index = first; index <= last; index++)
            lines_lengths[index] = tempArray[index];
    }

    //////////////////////////////// SHELL SORT ///////////////////////////////////////////////////

    /**
     * Performs a Shell Sort on the global array `lines_lengths`, which contains
     * integer values representing the lengths of lines. The Shell Sort algorithm is an
     * optimization over the simple insertion sort algorithm that allows the exchange of
     * items that are far apart. The goal is to reduce the total number of moving operations.
     * The sorting process's duration is calculated and stored in `SortGUI.shellTime`.
     */
    public  void ShellSort(){
        //start time
        Calendar start = Calendar.getInstance();
        // Begin with a large space, then reduce the space by half each iteration
        for(int space = total_number_of_lines/2;space>0;space=space/2){
            for(int begin=0;begin < space;begin++){
                // Call insertion sort that takes the space into account
                incrementalInsertionSort(begin,total_number_of_lines-1,space);
                paintComponent(this.getGraphics());
                delay(10);
            }

        }
        //end time
        Calendar end = Calendar.getInstance();
        //calculating total time taken and will be used to update the UI for total time taken for shell sort
        SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
    }

    /**
     * Performs an incremental insertion sort on a specified range of the `lines_lengths` array,
     * considering a specific gap between elements. This method is a part of the Shell Sort algorithm.
     *
     * @param first The starting index of the range to be sorted.
     * @param last The ending index of the range to be sorted.
     * @param space The gap between elements to be considered during the sort.
     */
    public void incrementalInsertionSort(int first,int last,int space){
        int unSorted,index;
        // Iterate over elements, jumping by space to perform insertion sort
        for(unSorted=first+space;unSorted<=last;unSorted=unSorted+space){
            // Store the current element to be sorted
            int firstUnsorted=lines_lengths[unSorted];
            // Compare and shift elements within the space;
            for(index=unSorted-space;(index>=first) && (firstUnsorted < lines_lengths[index]);index=index-space){
                // Shift the element to space position to make room for the unsorted element
                lines_lengths[index+space] = lines_lengths[index];
            }
            // Insert the unsorted element into its correct position
            lines_lengths[index+space] = firstUnsorted;
        }

    }
    //////////////////////////////// QUICK SORT RECURSIVE ///////////////////////////////////////////////////
    /**
     * Performs a Quick Sort on the global array `lines_lengths`. This method captures the start and end
     * times of the sorting process to calculate and update the sorting duration in `SortGUI.shellTime`.
     * The method initiates a recursive quick sort algorithm to sort the entire array.
     */
    public void R_QuickSort(){
        //capture start time of quick sort
        Calendar start = Calendar.getInstance();

        //call recursive quick sort
        R_QuickSort(0,total_number_of_lines-1);

        //capture end time of quick sort
        Calendar end = Calendar.getInstance();

        //calculate total time taken for shell time and update ui
        SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
    }

    /**
     * Recursively sorts a specified segment of the `lines_lengths` array using the Quick Sort algorithm.
     * For partitions smaller than a threshold (here, 3 elements), an insertion sort is used for efficiency.
     *
     * @param first The starting index of the segment to be sorted.
     * @param last The ending index of the segment to be sorted.
     */
    public void R_QuickSort(int first,int last){
        paintComponent(this.getGraphics());
        delay(10);

        //if partition size is less than 5 then do insertion sort
        if(last-first+1<3){
            insertionSort(first,last);
        }
        else{
            //get pivot index by doing partition
            int pivotIndex = partition(first,last);

            //sort array before pivot
            R_QuickSort(first,pivotIndex-1);

            //sort array after pivot
            R_QuickSort(pivotIndex+1,last);
        }
    }

    /**
     * Partitions a segment of the `lines_lengths` array for the Quick Sort algorithm, selecting a pivot
     * and rearranging elements such that those less than the pivot i.e. 'E' are moved before it i.e 'L', and those greater
     * are moved after it i.e. 'G'. The method returns the final index of the pivot element after partitioning.
     *
     * @param first The starting index of the segment to partition.
     * @param last The ending index of the segment to partition.
     * @return The final index of the pivot element.
     */
    public int partition(int first,int last){
        // Choose the middle element as the pivot
        int mid = first+(last-first)/2;
        // Sort the first, middle, and last elements and use the middle as the pivot
        sortFirstMiddleLast(first,mid,last);
        // Move the pivot to the second to last position
        swap(mid,last-1);
        int pivotIndex=last-1;

        int pivotValue = lines_lengths[pivotIndex];

        // Start searching for the crossing point from both ends
        int indexFromLeft = first+1;
        int indexFromRight = last -2;

        boolean done=false;
        while(!done){
            // Move from left to right as long as elements are less than the pivot
            while(lines_lengths[indexFromLeft] < pivotValue)
                indexFromLeft++;
            // Move from right to left as long as elements are greater than the pivot
            while(lines_lengths[indexFromRight] > pivotValue)
                indexFromRight--;

            // If the indices have not crossed, swap elements and continue
            if(indexFromLeft<indexFromRight){
                swap(indexFromLeft,indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            }
            else{
                done=true;
            }
        }
        // Place the pivot in its correct position and return its index
        swap(pivotIndex,indexFromLeft);
        pivotIndex=indexFromLeft;

        return pivotIndex;
    }

    /**
     * Sorts the first, middle, and last elements of a segment in the `lines_lengths` array
     * and ensures that the median of the three is in the middle position.
     *
     * @param first The index of the first element.
     * @param mid The index of the middle element.
     * @param last The index of the last element.
     */
    private void sortFirstMiddleLast(int first,int mid,int last){
        // Ensure the first is less than the middle
        order(first,mid);
        // Ensure the middle is less than the last
        order(mid,last);
        // Ensure the first is less than the middle again in case the last was smaller than both
        order(first,mid);
    }

    /**
     * Ensures that two specified elements in the `lines_lengths` array are in ascending order.
     * If not, they are swapped.
     *
     * @param first The index of the first element to compare.
     * @param last The index of the second element to compare.
     */
    private void order(int first,int last){
        // If the first element is greater than the last, swap them
        if(lines_lengths[first]>lines_lengths[last])
            swap(first,last);
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    //This method resets the window to the scrambled lines display
    public void reset() {
        if (scramble_lines != null) {
            //copying the old scrambled lines into lines_lengths
            for (int i = 0; i < total_number_of_lines; i++) {
                lines_lengths[i] = scramble_lines[i];
            }
            //Drawing the now scrambled lines_lengths
            paintComponent(this.getGraphics());
        }
    }


    //This method colours the lines and prints the lines
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //A loop to assign a colour to each line
        for (int i = 0; i < total_number_of_lines; i++) {
            //using eight colours for the lines
            if (i % 8 == 0) {
                g.setColor(Color.green);
            } else if (i % 8 == 1) {
                g.setColor(Color.blue);
            } else if (i % 8 == 2) {
                g.setColor(Color.yellow);
            } else if (i % 8 == 3) {
                g.setColor(Color.red);
            } else if (i % 8 == 4) {
                g.setColor(Color.black);
            } else if (i % 8 == 5) {
                g.setColor(Color.orange);
            } else if (i % 8 == 6) {
                g.setColor(Color.magenta);
            } else
                g.setColor(Color.gray);

            //Drawing the lines using the x and y-components
            g.drawLine(4 * i + 25, 300, 4 * i + 25, 300 - lines_lengths[i]);
        }

    }

    //A delay method that pauses the execution for the milliseconds time given as a parameter
    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}

