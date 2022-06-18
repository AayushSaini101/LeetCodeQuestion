class WordFilter
{

private final Trie trie = new Trie();

public WordFilter(String[] words)
{
	for (var i = 0; i < words.length; i++)
    {
		var joined = words[i].concat("-").concat(words[i]);
		for (var j = 0; j < words[i].length(); j++)
			trie.insert(joined, j, i);
	}
}

public int f(String prefix, String suffix)
{
	var node = trie.root;
	var query = suffix.concat("-").concat(prefix);

	for (var i = 0; i < query.length(); i++)
    {
		var key = query.charAt(i);
		if (!node.children.containsKey(key))
			return -1;
		node = node.children.get(key);
	}
	return node.index;
}

private static class Trie
{
	private final TrieNode root = new TrieNode();

	public void insert(String joined, int start, int index)
    {
		var node = root;
		for (var i = start; i < joined.length(); i++)
        {
			node = node.children.computeIfAbsent(joined.charAt(i), k -> new TrieNode());
			node.index = index;
		}
	}

	private static class TrieNode
    {
		private final Map<Character, TrieNode> children = new HashMap<>(27);
		private int index;
	}
}
}