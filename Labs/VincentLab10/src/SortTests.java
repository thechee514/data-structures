public class SortTests
{
    public static void main(String[] args)
    {
        Testing.setVerbose(true);

        Testing.startTests();

        minTests();
        sortTests();
        shortSortTests();

        Testing.finishTests();
    }

    public static void minTests()
    {
        Testing.testSection("Min Tests");
        String[] array = { "alpha", "beta", "gamma", "delta" };

        Sorter sortie = new Sorter();
        Testing.assertEquals("overall min is in position 0", 0,
                             sortie.getMinIndex(array, 0, 3));

        Testing.assertEquals("min of first 2 is in position 0", 0,
                             sortie.getMinIndex(array, 0, 1));

        Testing.assertEquals("min of second through fourth is in position 1",
                             1, sortie.getMinIndex(array, 1, 3));
    }

    public static void sortTests()
    {
        Testing.testSection("Sorting Tests");
        String[] starting = { "alpha", "beta", "gamma", "delta" };
        String[] expected = { "alpha", "beta", "delta", "gamma" };
        Sorter sortie = new Sorter();
        String[] actual = sortie.sort(starting);

        Testing.assertEquals("delta should swap with gamma", expected, actual);

        String[] reverse = { "gamma", "delta", "beta", "alpha" };
        actual = sortie.sort(reverse);
        Testing.assertEquals("array should be reversed", expected, actual);
    }

    public static void shortSortTests()
    {
        Testing.testSection("Sorting short arrays");

        String[] shortArray = { "A" };
        String[] expected = { "A" };
        Sorter sortie = new Sorter();

        Testing.assertEquals("a single element array", expected,
                             sortie.sort(shortArray));

        String[] reallyShort = {};
        String[] expectedEmpty = {};
        Testing.assertEquals("an empty array", expectedEmpty,
                             sortie.sort(reallyShort));

        String[] twoElementsReversed = { "B", "A" };
        String[] twoElementsSorted = { "A", "B" };

        Testing.assertEquals("two elements, reversed", twoElementsSorted,
                             sortie.sort(twoElementsReversed));
        Testing.assertEquals("two elements, already sorted",
                             twoElementsSorted, sortie.sort(twoElementsSorted));

    }

}
