import type { User } from "@/types/user.type";
import type { User as UserPrivy } from "@privy-io/react-auth";

export const flattenUser = (user: UserPrivy | null): User | null => {
  if (!user) return null;

  const emailAccount = user.linkedAccounts.find((a) => "email" in a) as any;
  const eoaWallet = user.wallet?.address;
  const smartWallet = user.smartWallet?.address;

  return {
    id: user.id,
    email: emailAccount?.email,
    name: emailAccount.name || emailAccount.username,
    eoaAddress: eoaWallet,
    smartAddress: smartWallet,
    loginType: user.linkedAccounts[0].type,
  };
};
