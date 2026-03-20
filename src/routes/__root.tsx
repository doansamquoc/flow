import { createRootRoute, Outlet } from "@tanstack/react-router";
import { PrivyProvider } from "@privy-io/react-auth";
import { NotFoundPage } from "./not-found";

const PRIVY_APP_ID = import.meta.env.VITE_PRIVY_APP_ID;
const PRIVY_CLIENT_ID = import.meta.env.VITE_PRIVY_CLIENT_ID;

export const Route = createRootRoute({
  component: () => (
    <PrivyProvider
      appId={PRIVY_APP_ID}
      clientId={PRIVY_CLIENT_ID}
      config={{
        appearance: {
          logo: "/logo.svg",
          theme: "light",
          accentColor: "#f5f5f5",
        },
        loginMethods: ["google", "email", "apple"],
        fundingMethodConfig: {
          moonpay: {
            useSandbox: true,
          },
        },
        embeddedWallets: {
          showWalletUIs: true,
          ethereum: {
            createOnLogin: "users-without-wallets",
          },
          priceDisplay: {
            primary: "fiat-currency",
            secondary: "native-token",
          },
        },
        mfa: {
          noPromptOnMfaRequired: false,
        },
      }}
    >
      <Outlet />
    </PrivyProvider>
  ),
  notFoundComponent: () => <NotFoundPage />,
});
