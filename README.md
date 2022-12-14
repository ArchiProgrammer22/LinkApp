Link App



Technologies used: View Binding, DI Hilt, Coroutines, Retrofit, Navigation, Room.
The application uses Clean Architecture and the MVVM architectural pattern.

![image](https://user-images.githubusercontent.com/70170204/199562212-dd4afe85-798a-44e9-a355-d1cefdd79bb9.png)


The application consists of 2 screens. The first screen is the progress bar, which is waiting for the execution of the coroutine, which fetches data from the API.

Retrofit is used to get the data. It sends a GET request to the server.

![image](https://user-images.githubusercontent.com/70170204/199563125-7d0ec8ee-588e-4b18-81b9-379e4a1dd7dd.png)

There is also local data caching, using the ORM Room.

![image](https://user-images.githubusercontent.com/70170204/199563519-519cdf53-f760-4c73-a08d-0541b2414c71.png)

One entity is used for Room and for Retrofit.

![image](https://user-images.githubusercontent.com/70170204/199563622-4e5d5d5a-122b-472b-9d3e-800472a7e6f6.png)

When the user first opens the application, the data is placed in local storage. The following launches already get local data.

![image](https://user-images.githubusercontent.com/70170204/199566615-aa8b5c1e-adcf-49f7-b829-56fa55974059.png)

When the data is delivered to the loading fragment, the second screen is immediately launched, in which the bundle with the link is passed. If this is the first launch of the application, then a link to Google is transmitted to the second screen, if not the first, then a link to YouTube.

![image](https://user-images.githubusercontent.com/70170204/199931407-a9bbe7a6-b02f-481c-a21c-bb3549e2b25a.png)

Display is possible thanks to WebView. There is navigation inside WebView. If there are no more pages in the WebView stack, then the next time you click the back button, the application is destroyed.

![image](https://user-images.githubusercontent.com/70170204/199931594-aef196fd-2ea7-41d4-b1a3-5481b02fd140.png)

Supports screen flip with data saving. It's possible because I use view model and extend LiveData with WebView generic and override some methods.

![image](https://user-images.githubusercontent.com/70170204/199932347-a4c134f5-894c-4cbf-9f38-60366e04c35d.png)

Additional Tasks:

Add the ability to go back in the webview when the back button is clicked.+

Save the parameters sent by the server and use them on subsequent launches.+

Run the application in full-screen mode, hiding the system ui.+

Add screen flip support (portrait and landscape modes) without restarting the webview and saving the state.+

Set any app icon.+


https://user-images.githubusercontent.com/70170204/199925675-738fabbb-fb92-4beb-9046-342317533567.mp4



