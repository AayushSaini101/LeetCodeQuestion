# Maximum selections [Public][Published]
## Medium 
<div class="problem-statement">
                <p><a onclick="gtagHelperFunction('clickopen','salesevent_gsc_problemspage_promobanner')" href="https://practice.geeksforgeeks.org/summer-carnival-2022?utm_source=practiceproblems&amp;utm_medium=problemspromobanner&amp;utm_campaign=gsc22" target="_blank"></a></p><div style="margin: 14px 0px !important;" class="row"><a onclick="gtagHelperFunction('clickopen','salesevent_gsc_problemspage_promobanner')" href="https://practice.geeksforgeeks.org/summer-carnival-2022?utm_source=practiceproblems&amp;utm_medium=problemspromobanner&amp;utm_campaign=gsc22" target="_blank">             <div class="col-md-12" style="cursor:pointer;background: #EFF8F3 0% 0% no-repeat padding-box; display: flex; align-items: center; position:                 relative; padding: 1.5%; border-radius: 10px; display: inline-block; text-align: center; font-weight: 600; color: #333"> <img src="https://media.geeksforgeeks.org/img-practice/gcs2022thumbnail-1649059370.png" alt="Lamp" width="46" height="40" style="background: transparent 0% 0% no-repeat padding-box;opacity: 1; margin: 0 16px;" class="img-responsive"> Geeks Summer Carnival is LIVE NOW &nbsp; <i class="fa fa-external-link" aria-hidden="true"></i> </div></a></div><p><span style="font-size:18px"><strong>Note: This&nbsp;<a href="http://practice.geeksforgeeks.org/problem-of-the-day" target="_blank">POTD</a>&nbsp;is a part of&nbsp;<a href="https://practice.geeksforgeeks.org/summer-carnival-2022?utm_source=potd&amp;utm_medium=problempage&amp;utm_campaign=gsc22" target="_blank">Geek Summer Carnival</a>. Solve all POTD consecutively from 5th to 10th April and get a chance to win exclusive discount vouchers on our GfG courses.</strong></span></p>

<hr>
<p><span style="font-size:18px">Geek wants to select the maximum number of course bundles at the Geek Summer Carnival.&nbsp;</span></p>

<p><span style="font-size:18px">You are given a finite number of courses and N range of numbers each depicting a bundle of courses.&nbsp;Select the maximum number of bundles such that no courses overlap in any of the bundle.</span></p>

<p><span style="font-size:18px"><strong>Note:</strong> The ending of a range being the same as start of another isn't considered as an overlap.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 4
Bundles = 
1 5
2 3
1 8
3 5</span>

<span style="font-size:18px"><strong>Output:</strong>
2</span>

<span style="font-size:18px"><strong>Explanation: 
<img alt="" src="https://media.geeksforgeeks.org/img-practice/ScreenShot2022-04-01at4-1648812950.png" style="height:65px; width:250px" class="img-responsive"></strong>
We can select 2 bundles at max while 
staying true to the condition. For this, 
we can pick the ranges (2,3) and (3,5) 
without any overlap. </span></pre>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 5
Bundles = 
7 9 
2 8 
1 3 
10 11 
10 16</span>

<span style="font-size:18px"><strong>Output:</strong>
3</span>

<span style="font-size:18px"><strong>Explanation: 
<img alt="" src="https://media.geeksforgeeks.org/img-practice/ScreenShot2022-04-01at4-1648813138.png" style="height:60px; width:400px" class="img-responsive"></strong>
We can pick the ranges (1,3), 
(7,9) and (10,11) without any overlap.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Complete the function <strong>max_non_overlapping()</strong> that takes&nbsp;a 2D array representing N ranges as input parameter. &nbsp;Return the maximum number of course bundles.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected time complexity: </strong>O(NlogN)<br>
<strong>Expected space complexity:</strong> O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 1000<br>
0 &lt;= range[i][j] &lt;= 1000</span></p>
 <p></p>
            </div>